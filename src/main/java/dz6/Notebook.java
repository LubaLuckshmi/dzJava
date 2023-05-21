package dz6;

import java.util.Objects;

public class Notebook {

        String name;
        int ram;
        int totalStorage;
        String os;
        String color;


        public Notebook(String name, int ram, int totalStorage, String os, String color)  {
            this.ram = ram;
            this.name = name;
            this.totalStorage = totalStorage;
            this.os = os;
            this.color = color;
        }


        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(name).append(" ").append(totalStorage);
            return builder.toString();
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, ram, totalStorage, os, color);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Notebook)) {
                return false;
            }

            Notebook temp = (Notebook) obj;
            return (temp.ram == this.ram && temp.totalStorage == temp.totalStorage && temp.os.equals(this.os) && temp.name.equals(this.name) && temp.color.equals(this.color));

        }

    }
