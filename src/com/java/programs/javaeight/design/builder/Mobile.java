package com.java.programs.javaeight.design.builder;

public class Mobile {
    @Override
    public String toString() {
        return "Mobile{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", processor='" + processor + '\'' +
                ", ram='" + ram + '\'' +
                '}';
    }

    private String name;
    private String colour;
    private String processor;
    private String ram;

    private Mobile(Builder builder){
        this.name = builder.name;
        this.colour = builder.colour;
        this.processor = builder.processor;
        this.ram = builder.ram;
    }

    public String getName() {
        return this.name;
    }

    public String getColour() {
        return this.colour;
    }

    public String getProcessor() {
        return this.processor;
    }

    public String getRam() {
        return this.ram;
    }

    static class Builder{
        private String name;
        private String colour;
        private String processor;
        private String ram;

        public Mobile build(){
            return new Mobile(this);
        }

        public Builder(String name){
            this.name = name;
        }
//        public Builder setName(String name) {
//            this.name = name;
//            return this;
//        }

        public Builder setColour(String colour) {
            this.colour = colour;
            return this;
        }

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }
    }

}
