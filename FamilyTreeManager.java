import java.util.ArrayList;
import java.util.Scanner;

class FamilyNode {
    String name;
    ArrayList<FamilyNode> children;

    public FamilyNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
}

public class FamilyTreeManager {
    private static FamilyNode root = new FamilyNode("Family");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Family Tree Manager ===");
            System.out.println("1. Add Family Member");
            System.out.println("2. View Family Tree");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                addFamilyMember(scanner);
            } else if (choice == 2) {
                viewFamilyTree(root, 0);
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addFamilyMember(Scanner scanner) {
        System.out.print("Enter the parent name (or 'Family' for the root): ");
        String parentName = scanner.nextLine();
        System.out.print("Enter the name of the new family member: ");
        String memberName = scanner.nextLine();

        FamilyNode parentNode = findOrCreateNode(root, parentName);
        parentNode.children.add(new FamilyNode(memberName));

        System.out.println("Family member added successfully!");
    }

    private static void viewFamilyTree(FamilyNode node, int level) {
        for (int i = 0; i < level; i++) System.out.print("  ");
        System.out.println("- " + node.name);
        for (FamilyNode child : node.children) {
            viewFamilyTree(child, level + 1);
        }
    }

    private static FamilyNode findOrCreateNode(FamilyNode parent, String name) {
        if (parent.name.equals(name)) return parent;
        for (FamilyNode child : parent.children) {
            if (child.name.equals(name)) return child;
        }
        
        FamilyNode newNode = new FamilyNode(name);
        parent.children.add(newNode);
        return newNode;
    }
          }
