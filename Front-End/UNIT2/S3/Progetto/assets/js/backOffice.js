
const baseUrl = 'https://striveschool-api.herokuapp.com/api/product/';

const addProductForm = document.getElementById('productForm')

addProductForm.addEventListener("submit", async (event) => {
  event.preventDefault();
  const formData = new FormData(addProductForm);
  const product = Object.fromEntries(formData.entries());

  try {
    const response = await fetch(baseUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZDYzZTJkN2IxMTAwMTkwZTZkY2UiLCJpYXQiOjE3MDk4ODkwODYsImV4cCI6MTcxMTA5ODY4Nn0.MNJxbluVwM9PHNe7Gp5FUZM3t97mK63sAS_7XovewMM"  ,
      },
      body: JSON.stringify(product),
    });

    if (!response.ok) {
      throw new Error("Network response was not ok");
    }
    const newProduct = await response.json();
    console.log("New product added:", newProduct);
  } catch (error) {
    console.error("Error adding product:", error);
  }
});




