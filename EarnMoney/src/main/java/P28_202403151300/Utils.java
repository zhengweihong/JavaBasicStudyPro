package P28_202403151300;

import java.io.*;
import java.util.*;

public class Utils {

    private static String USER_INFO_FILE_NAME = "EarnMoney/target/classes/P28_202403151300/userInfo.csv";
    private static String RENT_RECORD_FILE_NAME = "EarnMoney/target/classes/P28_202403151300/rentRecord.csv";
    private static String ITEM_INFO_FILE_NAME = "EarnMoney/target/classes/P28_202403151300/itemInfo.csv";
    private static String REQUEST_RECORD_FILE_NAME = "EarnMoney/target/classes/P28_202403151300/requestRecord.csv";
    private static String DISCOUNTED_PURCHASES_FILE_NAME = "EarnMoney/target/classes/P28_202403151300/discountedPurchases.csv";

    public static List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        // Adapter
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(USER_INFO_FILE_NAME))) {
            String aLine = null;
            while ((aLine = bufferedReader.readLine()) != null) {
                String[] userSplit = aLine.split(",");
                users.add(new User.UserBuilder()
                        .email(userSplit[0])
                        .password(userSplit[1])
                        .role(userSplit[2])
                        .using(Boolean.valueOf(userSplit[3]))
                        .build());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static User getUserByEmail(String email) {
        User user = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(USER_INFO_FILE_NAME))) {
            String aLine = null;
            while ((aLine = bufferedReader.readLine()) != null) {
                String[] userSplit = aLine.split(",");
                String emailSplit = userSplit[0];
                if (emailSplit != null && emailSplit.equals(email)) {
                    user = new User.UserBuilder()
                            .email(emailSplit)
                            .password(userSplit[1])
                            .role(userSplit[2])
                            .using(Boolean.valueOf(userSplit[3]))
                            .build();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void insertUser(User user) {
        if (user == null) {
            return;
        }

        String input = String.join(",", new String[]{user.getEmail(), user.getPassword(), user.getRole(), String.valueOf(user.getUsing())});
        // Adapter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_INFO_FILE_NAME, true))) {
            bw.newLine();
            bw.append(input);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_+<>:\"-}[{]";

    public static boolean isStrongPassword(String password) {
        if (password == null || "".equals(password)) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSymbol = false;

        for (char c : password.toCharArray()) {
            if (hasUpperCase && hasLowerCase && hasNumber && hasSymbol) {
                return true;
            }
            if (UPPERCASE_LETTERS.indexOf(c) != -1) {
                hasUpperCase = true;
            } else if (LOWERCASE_LETTERS.indexOf(c) != -1) {
                hasLowerCase = true;
            } else if (NUMBERS.indexOf(c) != -1) {
                hasNumber = true;
            } else if (SYMBOLS.indexOf(c) != -1) {
                hasSymbol = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasNumber && hasSymbol;
    }

    public static List<RentRecord> getRentRecordByUserEmail(String email) {
        List<RentRecord> rentRecords = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(RENT_RECORD_FILE_NAME))) {
            String aLine = null;
            while ((aLine = bufferedReader.readLine()) != null) {
                String[] recordSplit = aLine.split(",");
                String emailSplit = recordSplit[0];
                if (emailSplit != null && emailSplit.equals(email)) {
                    rentRecords.add(new RentRecord(
                            recordSplit[0], recordSplit[1], recordSplit[2], recordSplit[3]
                    ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rentRecords;
    }

    public static List<Item> getAllItem() {
        List<Item> items = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ITEM_INFO_FILE_NAME))) {
            String aLine = null;
            while ((aLine = bufferedReader.readLine()) != null) {
                String[] itemSplit = aLine.split(",");
                items.add(new Item(itemSplit[0], itemSplit[1], itemSplit[2], Boolean.valueOf(itemSplit[3]), Integer.valueOf(itemSplit[4])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void rewriteItemInfo(List<Item> items) {
        if (items == null || items.size() == 0) {
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ITEM_INFO_FILE_NAME))) {
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                bw.append(String.join(",", new String[]{
                        item.getId(), item.getName(), item.getLocation(), String.valueOf(item.getCanRent()), String.valueOf(item.getNumbers())
                }));
                if (i < items.size() - 1) {
                    bw.newLine();
                }
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertRentRecord(RentRecord rentRecord) {
        if (rentRecord == null) {
            return;
        }

        String input = String.join(",", new String[]{
                rentRecord.getUserEmail(), rentRecord.getItemId(), rentRecord.getItemName(), rentRecord.getDueDate()
        });
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RENT_RECORD_FILE_NAME, true))) {
            bw.newLine();
            bw.append(input);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rewriteUserInfo(List<User> users) {
        if (users == null || users.size() == 0) {
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_INFO_FILE_NAME))) {
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                bw.append(String.join(",", new String[]{
                        user.getEmail(), user.getPassword(), user.getRole(), String.valueOf(user.getUsing())
                }));
                if (i < users.size() - 1) {
                    bw.newLine();
                }
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertItem(Item item) {
        if (item == null) {
            return;
        }

        String input = String.join(",", new String[]{item.getId(), item.getName(), item.getLocation(), String.valueOf(item.getCanRent()), String.valueOf(item.getNumbers())});
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ITEM_INFO_FILE_NAME, true))) {
            bw.newLine();
            bw.append(input);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertRequestRecord(String str) {
        if (str == null || "".equals(str)) {
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(REQUEST_RECORD_FILE_NAME, true))) {
            bw.newLine();
            bw.append(str);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<RequestRecord> getAllRequest() {
        List<RequestRecord> requestRecords = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(REQUEST_RECORD_FILE_NAME))) {
            String aLine = null;
            while ((aLine = bufferedReader.readLine()) != null) {
                String[] itemSplit = aLine.split(",");
                requestRecords.add(new RequestRecord(itemSplit[0], itemSplit[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestRecords;
    }

    public static Map<String, DiscountedPurchase> getAllDiscountedPurchaseMap() {
        Map<String, DiscountedPurchase> discountedPurchases = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DISCOUNTED_PURCHASES_FILE_NAME))) {
            String aLine = null;
            while ((aLine = bufferedReader.readLine()) != null) {
                String[] itemSplit = aLine.split(",");
                discountedPurchases.put(itemSplit[0],
                        new DiscountedPurchase(itemSplit[0], Integer.valueOf(itemSplit[1]), Double.valueOf(itemSplit[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return discountedPurchases;
    }
}
