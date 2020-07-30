package com.alfa.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class NumberThree {
    public static void main(String[] args) {
        var list = List.of(
                new PurchaseModel("SO-921", "2018-02-17T03:24:12", new CustomerModel(33, "Ari"),
                        List.of(
                                new ItemModel(24, "Sapu Lidi", 2, 13200),
                                new ItemModel(73, "Sprei 160x200 polos", 1, 149000)
                        )),
                new PurchaseModel("SO-922", "2018-02-20T13:10:32", new CustomerModel(40, "Ririn"),
                        List.of(
                                new ItemModel(83, "Sapu Lidi", 1, 13200),
                                new ItemModel(24, "Rice Cooker", 1, 258000),
                                new ItemModel(30, "Teflon", 1, 190000)
                        )),
                new PurchaseModel("SO-923", "2018-02-28T15:20:43", new CustomerModel(33, "Ari"),
                        List.of(
                                new ItemModel(303, "Pematik Api", 1, 12000),
                                new ItemModel(49, "Panci", 2, 70000)
                        )),
                new PurchaseModel("SO-924", "2018-03-02T14:30:54", new CustomerModel(40, "Ririn"),
                        List.of(
                                new ItemModel(986, "TV LCD 40 inch", 1, 6000000)
                        )),
                new PurchaseModel("SO-925", "2018-03-03T14:52:22", new CustomerModel(33, "Ari"),
                        List.of(
                                new ItemModel(1033, "Nintendo Switch", 1, 4990000),
                                new ItemModel(2003, "Macbook Air 11 inch 128 GB", 1, 12000000),
                                new ItemModel(23, "Pocari Sweat 600ML", 1, 7000)
                        )),
                new PurchaseModel("SO-926", "2018-03-05T16:23:20", new CustomerModel(58, "Annis"),
                        List.of(
                                new ItemModel(24, "Sapu Lidi", 3, 13200)
                        ))
        );

        // Kerjakan di bawah ini

        // 1
        list.stream().filter(s -> {
            var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            var date = LocalDateTime.parse(s.createdAt, formatter);

            return date.getMonthValue() == 2;
        }).forEach(System.out::println);

        System.out.println("\n---\n");

        // 2
        var total = list.stream()
                .filter(s -> s.customer.name.equalsIgnoreCase("ari"))
                .map(s -> s.items.stream()
                        .map(x -> x.price * x.qty)
                        .reduce(0, Integer::sum))
                .reduce(0, Integer::sum);
        System.out.println("Total harga dari semua item yang dibeli oleh Ari: " + total);

        System.out.println("\n---\n");

        // 3
        var customers = list.stream()
                .filter(s -> s.items.stream()
                        .map(x -> x.price * x.qty)
                        .reduce(0, Integer::sum) < 300000)
                .map(s -> s.customer.name)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(customers);

        System.out.println("\n--- Version 2.0\n");

    }

    private static class CustomerModel {
        public int id;
        public String name;

        public CustomerModel(int id, String name) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return "{" + "\"id\":" + id + ", \"name\":\"" + name + '\"' + '}';
        }
    }

    private static class ItemModel {
        public int id, qty, price;
        public String name;

        public ItemModel(int id, String name, int qty, int price) {
            this.price = price;
            this.qty = qty;
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "{" + "\"id\":" + id + ", \"qty\":" + qty + ", \"price\":" + price + ", \"name\":\"" + name + "\"}";
        }
    }

    private static class PurchaseModel {
        public String orderId, createdAt;
        public CustomerModel customer;
        public List<ItemModel> items;

        PurchaseModel(String orderId, String createdAt, CustomerModel customer, List<ItemModel> items) {
            this.createdAt = createdAt;
            this.orderId = orderId;
            this.customer = customer;
            this.items = items;
        }

        @Override
        public String toString() {
            return "{" + "\"orderId\":\"" + orderId + '\"' + ", \"createdAt\":\"" + createdAt + '\"' + ", \"customer\":" + customer +
                    ", \"items\":" + items + '}';
        }
    }
}

