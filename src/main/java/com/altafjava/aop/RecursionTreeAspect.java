package com.altafjava.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class RecursionTreeAspect {

	private int depth = 0; // Track recursion depth
	private List<String> recursionTree = new ArrayList<>();

	@Around("execution(* *..*(..)) && @annotation(Print)")
	public Object trackRecursion(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		StringBuilder entry = new StringBuilder();
		// Build tree structure with proper indentation
		for (int i = 0; i < depth; i++) {
			entry.append(i == depth - 1 ? "├── " : "│   ");
		}
		// Append the method name and args with names
//        entry.append(methodName).append("(").append(formatArgs(joinPoint)).append(")");
		entry.append("(").append(formatArgs(joinPoint)).append(")");
		recursionTree.add(entry.toString());
		depth++; // Increase depth for nested recursion calls
		Object result = joinPoint.proceed(); // Proceed with the actual method logic
		depth--; // Decrease depth as recursion unwinds
		// Print the final tree structure when recursion ends (at the root level)
		if (depth == 0) {
			printTree();
			recursionTree.clear(); // Clear for the next set of calls
		}
		return result;
	}

	// Format arguments to include parameter names, excluding those with @Omit
	private String formatArgs(ProceedingJoinPoint joinPoint) {
		StringBuilder sb = new StringBuilder();
		String[] parameterNames = ((org.aspectj.lang.reflect.MethodSignature) joinPoint.getSignature()).getParameterNames();
		Object[] args = joinPoint.getArgs();
		Method method = ((org.aspectj.lang.reflect.MethodSignature) joinPoint.getSignature()).getMethod();
		java.lang.reflect.Parameter[] parameters = method.getParameters();
		for (int i = 0; i < args.length; i++) {
			if (!parameters[i].isAnnotationPresent(Omit.class)) {
				// Format the parameter name and value
				sb.append(parameterNames[i]).append(": ");
				// Handle different types of arguments for formatting
				if (args[i] instanceof int[]) {
					sb.append(Arrays.toString((int[]) args[i])); // Format int array
				} else if (args[i] instanceof Object[]) {
					sb.append(Arrays.deepToString((Object[]) args[i])); // Format object array
				} else {
					sb.append(args[i]); // Format other types
				}
				// Add a comma and space if not the last argument
				if (i < args.length - 1) {
					sb.append(", ");
				}
			}
		}
		return sb.toString();
	}

//	// It will print array.toString() instead of original values
//	private String formatArgs(ProceedingJoinPoint joinPoint) {
//		StringBuilder sb = new StringBuilder();
//		String[] parameterNames = ((org.aspectj.lang.reflect.MethodSignature) joinPoint.getSignature()).getParameterNames();
//		Object[] args = joinPoint.getArgs();
//		Method method = ((org.aspectj.lang.reflect.MethodSignature) joinPoint.getSignature()).getMethod();
//		java.lang.reflect.Parameter[] parameters = method.getParameters();
//
//		for (int i = 0; i < args.length; i++) {
//			if (!parameters[i].isAnnotationPresent(Omit.class)) {
//				sb.append(parameterNames[i]).append(":").append(args[i].toString());
//				if (i < args.length - 1) {
//					sb.append(", ");
//				}
//			}
//		}
//		return sb.toString();
//	}

	// Print the final tree-like structure
	private void printTree() {
		for (String line : recursionTree) {
			System.out.println(line);
		}
		System.out.println();
	}
}
