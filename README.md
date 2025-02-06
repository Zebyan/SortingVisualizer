# SortingVisualizer: https://sorting-visualizer-sigma-sandy.vercel.app/
-!!! The backend server might take a bit longer to start (it's a free hosting plan).
-! Please keep in mind that bubble and selection sort are slower algorithms O(n^2), so be carefull when adjusting the delay.

# Overview
The Sorting Visualizer allows users to see real-time animations of different sorting algorithms as they work on random arrays. The application consists of:

  -Frontend: A React application that provides a modern, tech-inspired UI with animated sorting visualizations, adjustable array sizes, speed controls, and a tutorial overlay for first-time users.
  -Backend: A Spring Boot (Java) API that processes sorting requests and returns step-by-step sorting steps for multiple algorithms (Quick Sort, Merge Sort, Bubble Sort, Selection Sort).

#Features
-Multiple Sorting Algorithms: Quick Sort, Merge Sort, Bubble Sort, and Selection Sort.
-Step-by-Step Animation: The frontend animates each step of the sorting process with visual cues (color changes for comparisons->yellow, swaps->red, and sorted elements->green).
-Customizable Controls: Users can adjust array size and sorting speed using slider controls.
-Modern UI: The app features a sleek, tech-inspired design with gradient backgrounds, bouncing animations for the header, and stylish buttons.
-Full-Stack Deployment: The backend is containerized with Docker and deployed on Render, while the frontend is deployed on Vercel.

# Tech-Stack
  # Frontend:
  - CSS: For custom styling and animations (including modern gradients, transitions, and hover effects).
  - Javascrip(React): for building an interactive UI
  # Backend: 
  - Java Spring Boot:  For creating RESTful APIs that process sorting algorithms.
  - Maven: For dependency management and building the application.
  - Docker: For containerizing the backend application.
  - Sorting Algorithms: Implemented in Java (Quick Sort, Merge Sort, Bubble Sort, Selection Sort) with step-by-step logging.
  # Deployment & DevOps
  - Render: For deploying the Dockerized Spring Boot backend.
  - Vercel: For hosting the React frontend.
  - Git & GitHub: For version control and code hosting.

# How does it work?
  - When one of the sorting buttons is clicked, a post request is sent to our backend:
  -   eg:{
  "algorithm": "quick",  // Options: "quick", "merge", "bubble", "selection"
  "array": [5, 2, 6, 3, 1]
}
 # Response: A JSON array of sort steps, with each step containing:
  "array": The current state of the array.
  "index1" and "index2": The indices involved in the current step.
  "swapped": Boolean indicating if a swap occurred.
  "sorted": Boolean indicating if the element(s) are in their final sorted position.
