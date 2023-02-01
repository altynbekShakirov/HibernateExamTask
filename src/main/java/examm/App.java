package examm;


import examm.config.HibernateConfig;
import examm.model.Instagram_account;
import examm.model.Post;
import examm.model.User;
import examm.service.UserService;
import examm.service.servece.InstagramAccountServiceImpl;
import examm.service.servece.PostServiceImpl;
import examm.service.servece.UserServiceImpl;

import java.util.Optional;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static UserService userService = new UserServiceImpl();
    private static InstagramAccountServiceImpl instagramAccountService = new InstagramAccountServiceImpl();
    private static PostServiceImpl postService = new PostServiceImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1: User \n2: Instagram Account \n3: Post + ");
            int scNum = new Scanner(System.in).nextInt();
            switch (scNum) {
                case 1 -> {
                    boolean trueOrFalse = true;
                    while (trueOrFalse) {
                        System.out.println("""
                                USER:
                                1: SAVE 
                                2: GET BY ID
                                3: UPDATE BY ID
                                4: DELETE BY ID
                                5,6,.,. : EXIT
                                """);
                        switch (new Scanner(System.in).nextInt()) {
                            case 1 -> {
                                System.out.println("    SAVE");
                                System.out.println("Full Name :");
                                String fullName = new Scanner(System.in).nextLine();
                                System.out.println("Date Of Birth :");
                                String dateOfBirth = new Scanner(System.in).nextLine();
                                System.out.println(userService.save(new User(fullName, dateOfBirth)));
                            }
                            case 2 -> {
                                System.out.println("    GET BY ID");
                                System.out.println("ID :");
                                Long id = new Scanner(System.in).nextLong();
                                System.out.println(userService.getById(id));
                            }
                            case 3 -> {
                                System.out.println("   UPDATE BY ID");
                                System.out.println("ID :");
                                Long id = new Scanner(System.in).nextLong();
                                System.out.println("New User :");
                                System.out.println("Full Name : ");
                                String fullName = new Scanner(System.in).nextLine();
                                System.out.println("Date Of Birth: ");
                                String dateOfBirth = new Scanner(System.in).nextLine();
                                User user = new User(fullName, dateOfBirth);
                                System.out.println(userService.updateById(id, user));
                            }
                            case 4 -> {
                                System.out.println("DELETE BY ID:");
                                System.out.println("ID: ");
                                Long id = new Scanner(System.in).nextLong();
                                userService.deleteById(id);
                                System.out.println("Successfully deleted");
                            }
                            default -> trueOrFalse = false;
                        }
                    }
                }
                case 2 -> {
                    boolean trueOrFalse = true;
                    while (trueOrFalse) {
                    System.out.println("""
                            INSTAGRAM ACCOUNT:
                            1: SAVE
                            2: GET BY ID
                            3: EXIST BY EMAIL
                            4: CHANGE PASSWORD
                            5: UPDATE BY ID 
                            6: EXIT
                                                           
                            """);
                    switch (new Scanner(System.in).nextInt()) {
                        case 1 -> {
                            System.out.println("Save:");
                            System.out.println("User Name:");
                            String userName = new Scanner(System.in).nextLine();
                            System.out.println("Login:");
                            String login = new Scanner(System.in).nextLine();
                            System.out.println("Password: ");
                            String password = new Scanner(System.in).nextLine();
                            System.out.println("User Id");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(instagramAccountService.save(new Instagram_account(userName, login, password), id));
                        }
                        case 2 -> {
                            System.out.println("Get By Id:");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(instagramAccountService.getById(id));
                        }
                        case 3 -> {
                            System.out.println("Exist By Email:");
                            System.out.println("Login:");
                            String login = new Scanner(System.in).nextLine();
                            System.out.println(instagramAccountService.existByEmail(login));
                        }
                        case 4 -> {
                            System.out.println("Change Password:");
                            System.out.println("id");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println("New Password:");
                            String password = new Scanner(System.in).nextLine();
                            System.out.println(instagramAccountService.changePassport(id, password));
                        }
                        case 5 -> {
                            System.out.println("Update By Id:");
                            System.out.println("ID");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println("User Name: ");
                            String userName = new Scanner(System.in).nextLine();
                            System.out.println("Login:");
                            String login = new Scanner(System.in).nextLine();
                            System.out.println("Password: ");
                            String password = new Scanner(System.in).nextLine();
                            System.out.println(instagramAccountService.updateById(id, new Instagram_account(userName, login, password)));
                        }
                        default -> trueOrFalse=false;


                    }
                    }


                }
                case 3 -> {
                    boolean trueOrFalse = true;
                    while (trueOrFalse) {
                    System.out.println("""
                            1: SAVE
                            2: GET BY ID
                            3: UPDATE BY ID
                            4: DELETE BY ID 
                            5: EDIT DESCRIPTION
                            6: EXIT
                            """);
                    switch (new Scanner(System.in).nextInt()) {
                        case 1 -> {
                            System.out.println("Save: ");
                            System.out.println("Image: ");
                            String image = new Scanner(System.in).nextLine();
                            System.out.println("Description: ");
                            String description = new Scanner(System.in).nextLine();
                            System.out.println("Publication data: ");
                            String publicationData = new Scanner(System.in).nextLine();
                            System.out.println("Instagram Id: ");
                            Long instagramId = new Scanner(System.in).nextLong();
                            System.out.println(postService.save(new Post(image, description, publicationData), instagramId));
                        }
                        case 2 -> {
                            System.out.println("Get By Id:");
                            System.out.println("ID:");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(postService.getById(id));

                        }
                        case 3 -> {
                            System.out.println("Update By Id:");
                            System.out.println("Id:");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println("Image:  ");
                            String image = new Scanner(System.in).nextLine();
                            System.out.println("Description: ");
                            String description = new Scanner(System.in).nextLine();
                            System.out.println("Publication data: ");
                            String publicationData = new Scanner(System.in).nextLine();
                            System.out.println(postService.updateById(id, new Post(image, description, publicationData)));
                        }
                        case 4 -> {
                            System.out.println("Delete By Id:");
                            System.out.println("Id");
                            Long id = new Scanner(System.in).nextLong();
                            postService.deleteById(id);
                        }
                        case 5 -> {
                            System.out.println("Edit Description:");
                            System.out.println("ID:");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println("New Description: ");
                            String description = new Scanner(System.in).nextLine();
                            System.out.println(postService.editDescription(id, description));
                        }
                        default -> trueOrFalse=false;
                    }

                    }

                }


            }
        }


    }

}
