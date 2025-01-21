const API_BASE_URL = "http://localhost:8080/employees";

// DOM Elements
const form = document.getElementById("employee-form");
const employeeTable = document.getElementById("employee-table");
const searchInput = document.getElementById("search");
const nameInput = document.getElementById("name");
const emailInput = document.getElementById("email");
const phoneInput = document.getElementById("phone");
const departmentInput = document.getElementById("department");
const employeeIdInput = document.getElementById("employee-id");


function validateForm() {
  let valid = true;
  let errorMessage = "";

  
  if (!nameInput.value.trim() || nameInput.value.length < 3) {
    valid = false;
    errorMessage += "Name must be at least 3 characters long.\n";
  }

  // Email validation (required and valid email format)
  const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  if (!emailInput.value.trim() || !emailRegex.test(emailInput.value)) {
    valid = false;
    errorMessage += "Please enter a valid email address.\n";
  }

  // Phone number validation (required and 10 digits)
  const phoneRegex = /^[0-9]{10}$/;
  if (!phoneInput.value.trim() || !phoneRegex.test(phoneInput.value)) {
    valid = false;
    errorMessage += "Phone number must be 10 digits.\n";
  }

  // Department validation (required)
  if (!departmentInput.value.trim()) {
    valid = false;
    errorMessage += "Department is required.\n";
  }

  if (!valid) {
    alert(errorMessage);
  }
  return valid;
}

// Fetch and display employees
function fetchEmployees(query = "") {
  axios
    .get(`${API_BASE_URL}${query ? `/search?query=${query}` : ""}`)
    .then((response) => {
      const employees = response.data.data || response.data; 
      renderEmployees(employees);
    })
    .catch((error) => {
      console.error("Error fetching employees:", error);
      alert("Failed to fetch employees. Please try again.");
    });
}

// Render employees in the table
function renderEmployees(employees) {
  employeeTable.innerHTML = ""; 

  if (!employees || employees.length === 0) {
    employeeTable.innerHTML = `<tr><td colspan="8">No employees found</td></tr>`;
    return;
  }

  employees.forEach((employee) => {
    const row = document.createElement("tr");

    row.innerHTML = `
      <td>${employee.id}</td>
      <td>${employee.name}</td>
      <td>${employee.email}</td>
      <td>${employee.phone}</td>
      <td>${employee.department}</td>
      <td>${employee.createdAt}</td>
      <td>${employee.updatedAt}</td>
      <td>
        <button class="edit" onclick="editEmployee(${employee.id})">Edit</button>
        <button class="delete" onclick="deleteEmployee(${employee.id})">Delete</button>
      </td>
    `;
    employeeTable.appendChild(row);
  });
}

// Add or update employee
form.addEventListener("submit", (e) => {
  e.preventDefault();

  // Validate the form before sending the request
  if (!validateForm()) {
    return; 
  }

  // Extract the employee data from the form inputs
  const id = employeeIdInput.value.trim();
  const employee = {
    name: nameInput.value,
    email: emailInput.value,
    phone: phoneInput.value,
    department: departmentInput.value,
  };

  // If employee ID is present, update the existing employee
  if (id) {
    axios
      .put(`${API_BASE_URL}/${id}`, employee)
      .then(() => {
        alert("Employee updated successfully!");
        fetchEmployees();  
        form.reset();
        employeeIdInput.value = "";  
      })
      .catch((error) => {
        console.error("Error updating employee:", error);
        alert("Failed to update employee. Please try again.");
      });
  } else {
    // If no employee ID, create a new employee
    axios
      .post(API_BASE_URL, employee)
      .then(() => {
        alert("Employee created successfully!");
        fetchEmployees();
        form.reset();
      })
      .catch((error) => {
        console.error("Error creating employee:", error);
        alert("Failed to create employee. Please try again.");
      });
  }
});

// Edit employee
function editEmployee(id) {
  axios
    .get(`${API_BASE_URL}/${id}`)
    .then((response) => {
      const employee = response.data.data || response.data;
      nameInput.value = employee.name;
      emailInput.value = employee.email;
      phoneInput.value = employee.phone;
      departmentInput.value = employee.department;
      employeeIdInput.value = employee.id; 
    })
    .catch((error) => {
      console.error("Error fetching employee details:", error);
      alert("Failed to fetch employee details. Please try again.");
    });
}

// Delete employee
function deleteEmployee(id) {
  if (!confirm("Are you sure you want to delete this employee?")) return;

  axios
    .delete(`${API_BASE_URL}/${id}`)
    .then(() => {
      alert("Employee deleted successfully!");
      fetchEmployees();  
    })
    .catch((error) => {
      console.error("Error deleting employee:", error);
      alert("Failed to delete employee. Please try again.");
    });
}

// Search employees
searchInput.addEventListener("input", () => {
  const query = searchInput.value.trim();
  fetchEmployees(query);  
});

// Initial fetch
fetchEmployees();
