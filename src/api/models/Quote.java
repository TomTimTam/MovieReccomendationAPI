package api.models;

public class Quote
{
    public String Author;

    public String Quote;

    public String Category;

    public Quote(String author, String quote, String category)
    {
        Author = author;
        Quote = quote;
        Category = category;
    }
}

