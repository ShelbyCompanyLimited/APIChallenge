package mapper.postRegister;

public class Tags {

    public static Tags.Builder builder() {
        return new Tags.Builder();
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

        public Tags.Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Tags.Builder withName(String name) {
            this.name = name;
            return this;
        }



        public Tags createInstance() {

            final Tags tags = new Tags();

            tags.setId(id);
            tags.setName(name);
            return tags;

        }

    }
}
