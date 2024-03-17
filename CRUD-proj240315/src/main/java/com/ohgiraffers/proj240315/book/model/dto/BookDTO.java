package com.ohgiraffers.proj240315.book.model.dto;

public class BookDTO {
    private int bookCode;
    private String bookName;
    private String publisher;
    private int releaseDate;
    private int amount;
    private int categoryCode;
    private char loanableYN;

    private static final int MIN_CATEGORY_CODE = 1;
    private static final int MAX_CATEGORY_CODE = 10;

    public BookDTO() {
    }

    public BookDTO(int bookCode, String bookName, String publisher, int releaseDate, int amount, int categoryCode, char loanableYN) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.amount = amount;
        this.categoryCode = categoryCode;
        this.loanableYN = loanableYN;
    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {

        if (categoryCode < MIN_CATEGORY_CODE || categoryCode > MAX_CATEGORY_CODE) {
            throw new IllegalArgumentException("Category code must be between " + MIN_CATEGORY_CODE + " and " + MAX_CATEGORY_CODE);
        }
        this.categoryCode = categoryCode;

    }

    public char getLoanableYN() {
        return loanableYN;
    }

    public void setLoanableYN(char loanableYN) {
        this.loanableYN = loanableYN;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookCode=" + bookCode +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", releaseDate=" + releaseDate +
                ", amount=" + amount +
                ", categoryCode=" + categoryCode +
                ", loanableYN=" + loanableYN +
                '}';
    }

}
