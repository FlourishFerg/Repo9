package com.example.repo9;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagt {

    // Enum for evaluation status
    enum EvaluationStatus {
        PENDING, IN_PROGRESS, COMPLETED
    }

    // Class representing an employee
    class Employee {
        private String username;
        private String password;
        private List<Goal> goals;
        private List<Evaluation> evaluations;

        public Employee(String username, String password) {
            this.username = username;
            this.password = password;
            this.goals = new ArrayList<>();
            this.evaluations = new ArrayList<>();
        }

        // Getters and setters

        public void setGoals(List<Goal> goals) {
            this.goals = goalss;
        }

        public void addGoal(Goal goal) {
            goals.add(goal);
        }

        public void addEvaluation(Evaluation evaluation) {
            evaluations.add(evaluation);
        }
    }

    // Class representing a goal
    class Goal {
        private String description;
        private boolean isAchieved;

        public Goal(String description) {
            this.description = description;
            this.isAchieved = false;
        }

        // Getters and setters
    }

    // Class representing an evaluation
    class Evaluation {
        private Employee evaluator;
        private Employee evaluatee;
        private EvaluationStatus status;
        private Date deadline;
        private String feedback;

        public Evaluation(Employee evaluator, Employee evaluatee, Date deadline) {
            this.evaluator = evaluator;
            this.evaluatee = evaluatee;
            this.status = EvaluationStatus.PENDING;
            this.deadline = deadline;
        }

        public void setStatus(EvaluationStatus status) {
            this.status = status;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }
    }

    // Class representing the Employee Performance Evaluation System
    public class PerformanceEvaluationSystem {
        private Map<String, Employee> employees;

        public PerformanceEvaluationSystem() {
            this.employees = new HashMap<>();
        }

        public void registerEmployee(String username, String password) {
            employees.put(username, new Employee(username, password));
        }

        public void setEmployeeGoals(String username, List<Goal> goals) {
            Employee employee = employees.get(username);
            if (employee != null) {
                employee.setGoals(goals);
            }
        }

        public void scheduleEvaluation(String evaluatorUsername, String evaluateeUsername, Date deadline) {
            Employee evaluator = employees.get(evaluatorUsername);
            Employee evaluatee = employees.get(evaluateeUsername);
            if (evaluator != null && evaluatee != null) {
                Evaluation evaluation = new Evaluation(evaluator, evaluatee, deadline);
                evaluator.addEvaluation(evaluation);
            }
        }

        // Other methods for tracking performance, generating reports, etc.

        public static void main(String[] args) {
            PerformanceEvaluationSystem system = new PerformanceEvaluationSystem();
            system.registerEmployee("manager1", "password1");
            system.registerEmployee("employee1", "password2");
            system.registerEmployee("employee2", "password3");

            List<Goal> goals = new ArrayList<>();
            goals.add(new Goal("Improve communication skills"));
            goals.add(new Goal("Complete project on time"));

            system.setEmployeeGoals("employee1", goals);

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, 1);
            Date deadline = calendar.getTime();
            system.scheduleEvaluation("manager1", "employee1", deadline);

            // Example usage:
            Employee employee1 = system.employees.get("employee1");
            if (employee1 != null) {
                List<Evaluation> evaluations = employee1.getEvaluations();
                for (Evaluation evaluation : evaluations) {
                    System.out.println("Evaluation for " + evaluation.getEvaluatee().getUsername() + " is " + evaluation.getStatus());
                }
            }
        }
    }

}
