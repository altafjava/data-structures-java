package com.altafjava.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RecursionTreePrinter {

    private static int depth = 0; // Track the recursion depth for indentation
    private static List<String> recursionTree = new ArrayList<>(); // Store the tree structure

    // Method to print the recursion tree
    public static void printTree() {
        for (String line : recursionTree) {
            System.out.println(line);
        }
    }

    // Start tracking a recursion call
    public static void enterMethod(String methodName, Object... args) {
        StringBuilder entry = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            entry.append(i == depth - 1 ? "├── " : "│   "); // Create indentation for the current depth
        }
        entry.append(methodName + " called with args: " + formatArgs(args));
        recursionTree.add(entry.toString());
        depth++;
    }

    // End tracking a recursion call
    public static void exitMethod(String methodName) {
        depth--;
        StringBuilder exit = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            exit.append(i == depth - 1 ? "└── " : "    ");
        }
        recursionTree.add(exit.toString());
    }

    // Helper to format arguments for printing
    private static String formatArgs(Object... args) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i].toString());
            if (i < args.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
