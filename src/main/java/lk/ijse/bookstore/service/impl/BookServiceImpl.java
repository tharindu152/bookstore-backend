package lk.ijse.bookstore.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import lk.ijse.bookstore.entity.SubCategory;
import lk.ijse.bookstore.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.dto.BookDTO;
import lk.ijse.bookstore.entity.Book;
import lk.ijse.bookstore.repository.BookRepository;
import lk.ijse.bookstore.service.BookService;


@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private SubCategoryRepository subCategoryRepository;

    private final Bucket bucket;

    @Autowired
    public BookServiceImpl (BookRepository bookRepository, SubCategoryRepository subCategoryRepository, Bucket bucket){
        this.bookRepository = bookRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.bucket = bucket;
    }


    @Override
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book ID " + id + " not found"));
    }

    @Override
    public Book createBook(BookDTO bookReqDTO) throws Exception {
        SubCategory subCategory = subCategoryRepository.findSubCategoriesBySubCategoryId(Long.valueOf(bookReqDTO.getSubCategoryId()));
        Book newBook = null;

        if(subCategory != null){
            String coverImage = bookReqDTO.getTitle() + "-" + bookReqDTO.getIsbn();
            String coverImageUrl = null;
            if(bookReqDTO.getCoverImage() != null && !bookReqDTO.getCoverImage().isEmpty()){
                Blob blob = bucket.create(coverImage, bookReqDTO.getCoverImage().getInputStream(), bookReqDTO.getCoverImage().getContentType());
                coverImageUrl = blob.signUrl(10, TimeUnit.DAYS, Storage.SignUrlOption.withV4Signature()).toString();
            }else {
                throw new NoSuchElementException("Book Cover image: " + bookReqDTO.getCoverImage() + " not found");
            }

            newBook = new Book( bookReqDTO.getAuthor(), bookReqDTO.getTitle(), coverImageUrl, bookReqDTO.getQuantity(), bookReqDTO.getPrice(),
                    bookReqDTO.getDescription(), bookReqDTO.getIsbn(), subCategory);
            return bookRepository.save(newBook);
        } else {
            throw new NoSuchElementException("Book SubCategory " + bookReqDTO.getSubCategoryId() + " not found");
        }
    }

    @Override
    public Book updateBook(Long id, BookDTO bookReqDTO) throws IOException {
        Book existingBook;
        String oldPicture;
        String newPicture = null;
        if(bookRepository.existsById(id)){
            existingBook = getBookById(id);
            existingBook.setAuthor(bookReqDTO.getAuthor());
            existingBook.setTitle(bookReqDTO.getTitle());

            String pictureUrl = null;
            if(bookReqDTO.getCoverImage() != null && !bookReqDTO.getCoverImage().isEmpty()){
                oldPicture = existingBook.getTitle() + "-" + existingBook.getIsbn();
                newPicture = bookReqDTO.getTitle() + "-" + bookReqDTO.getIsbn();
                if(bucket.get(oldPicture) != null){
                    bucket.get(oldPicture).delete();
                    Blob blob = bucket.create(newPicture, bookReqDTO.getCoverImage().getInputStream(), bookReqDTO.getCoverImage().getContentType());
                    pictureUrl = blob.signUrl(1, TimeUnit.DAYS, Storage.SignUrlOption.withV4Signature()).toString();
                } else {
                    throw new NoSuchElementException("Old cover image  " + oldPicture + " not found");
                }
            } else {
                throw new NoSuchElementException("New cover image  " + newPicture + " not found");
            }
            existingBook.setCoverImage(pictureUrl);
            existingBook.setQty(bookReqDTO.getQuantity());
            existingBook.setPrice(bookReqDTO.getPrice());
            existingBook.setDescription(bookReqDTO.getDescription());
            existingBook.setIsbn(bookReqDTO.getIsbn());

            SubCategory subCategory = subCategoryRepository.findSubCategoriesBySubCategoryId(Long.valueOf(bookReqDTO.getSubCategoryId()));
            existingBook.setSubCategory(subCategory);
        }else{
            throw new NoSuchElementException("Book ID " + id + " not found");
        }
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        if(bookRepository.existsById(id)){
            Book book = bookRepository.findBookById(id);
            String coverImage = book.getCoverImage();
            System.out.println(coverImage);
            if (coverImage != null) bucket.get(coverImage).delete();
            bookRepository.deleteById(id);
        }else{
            throw new NoSuchElementException("Book ID " + id + " not found");
        } 
    }

    @Override
    public List<Book> getBooksByCategoryId(Long categoryId) {
        return bookRepository.findBooksByCategoryId(categoryId);
    }
    
    @Override
    public List<Book> getBooksBySubCategoryId(Long subCategoryId) {
        return bookRepository.findBooksBySubCategoryId(subCategoryId);
    }

//    @Override
//    public List<Book> getBooksByQuery(String query) {
//        return bookRepository.findBooksByQuery(query);
//    }


}
