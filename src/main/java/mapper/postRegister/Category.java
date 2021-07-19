package mapper.postRegister;

public class Category {

    public static Category.Builder builder() {
        return new Category.Builder();
    }

    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static class Builder {

        private int id;
        private String name;

        public Category.Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Category.Builder withName(String name) {
            this.name = name;
            return this;
        }



        public Category createInstance() {

            final Category category = new Category();

            category.setId(id);
            category.setName(name);
            return category;

        }

    }
}
