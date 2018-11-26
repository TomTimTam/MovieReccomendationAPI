package api.models;

public enum QuoteCategory
{
    Movies("Movies"),
    Famous("Famous");

    private String name;

    QuoteCategory(final String categoryName)
    {
        this.name = categoryName;
    }

    @Override
    public String toString()
    {
        return name;
    }
}

