window.addEventListener('DOMContentLoaded', async () => {
    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get('id');

    try {
        const response = await fetch(`https://striveschool-api.herokuapp.com/api/product/${productId}`, {
            headers: {
                Authorization: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZDYzZTJkN2IxMTAwMTkwZTZkY2UiLCJpYXQiOjE3MDk4ODkwODYsImV4cCI6MTcxMTA5ODY4Nn0.MNJxbluVwM9PHNe7Gp5FUZM3t97mK63sAS_7XovewMM"
            },
        });

        if (!response.ok) {
            throw new Error("Network response was not ok");
        }

        const product = await response.json();

        document.getElementById('name').value = product.name;
        document.getElementById('brand').value = product.brand;
        document.getElementById('imageUrl').value = product.imageUrl;
        document.getElementById('price').value = product.price;
        document.getElementById('description').value = product.description;


        document.getElementById('productForm').addEventListener('submit', async (event) => {
            event.preventDefault()
            const formData = new FormData(event.target);
            const updatedProductData = Object.fromEntries(formData.entries());

            try {
                const updateResponse = await fetch(`https://striveschool-api.herokuapp.com/api/product/${productId}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZDYzZTJkN2IxMTAwMTkwZTZkY2UiLCJpYXQiOjE3MDk4ODkwODYsImV4cCI6MTcxMTA5ODY4Nn0.MNJxbluVwM9PHNe7Gp5FUZM3t97mK63sAS_7XovewMM'
                    },
                    body: JSON.stringify(updatedProductData)
                });

                if (!updateResponse.ok) {
                    throw new Error('Failed to update product');
                }

                const updatedProduct = await updateResponse.json();


                window.location.href = 'index.html';
            } catch (error) {
                console.error('Error updating product:', error);
            }
        });


        document.getElementById('deleteButton').addEventListener('click', async () => {
            try {
                const deleteResponse = await fetch(`https://striveschool-api.herokuapp.com/api/product/${productId}`, {
                    method: 'DELETE',
                    headers: {
                        'Authorization': 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZDYzZTJkN2IxMTAwMTkwZTZkY2UiLCJpYXQiOjE3MDk4ODkwODYsImV4cCI6MTcxMTA5ODY4Nn0.MNJxbluVwM9PHNe7Gp5FUZM3t97mK63sAS_7XovewMM'
                    }
                });

                if (!deleteResponse.ok) {
                    throw new Error('Failed to delete product');
                }


                window.location.href = 'index.html';
            } catch (error) {
                console.error('Error deleting product:', error);
            }
        });
    } catch (error) {
        console.error('Error fetching product:', error);
    }
});