package com.book.verse.ecommercebook.data;

import com.book.verse.ecommercebook.model.Books;

import java.util.List;

public class SearchBookResponse extends BasicResponse {
    private List<Books> resultList;

    public List<Books> getResultList() {
        return resultList;
    }

    public void setResultList(List<Books> resultList) {
        this.resultList = resultList;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "resultList=" + resultList +
                '}';
    }
}
