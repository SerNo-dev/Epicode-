
const baseUrl = 'https://striveschool-api.herokuapp.com/api/product/';

const fetchProducts = async () => {
    try {
        const response = await fetch(baseUrl, {
            headers: {
                Authorization: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZDYzZTJkN2IxMTAwMTkwZTZkY2UiLCJpYXQiOjE3MDk4ODkwODYsImV4cCI6MTcxMTA5ODY4Nn0.MNJxbluVwM9PHNe7Gp5FUZM3t97mK63sAS_7XovewMM"
            },
        });

        if (!response.ok) {
            throw new Error("Network response was not ok");
        }

        const products = await response.json();
        console.log("Products:", products);
        return products;
    } catch (error) {
        console.error("Error fetching products:", error);
        throw error;
    }
};

const createProductCard = (product) => {
    const card = document.createElement('div');
    card.classList.add('card', 'ms-5');

    const image = document.createElement('img');
    image.src = product.imageUrl;
    image.alt = product.name;
    card.appendChild(image);

    const cardBody = document.createElement('div');
    cardBody.classList.add('card-body');

    const title = document.createElement('h5');
    title.classList.add('card-title');
    title.textContent = product.name;
    cardBody.appendChild(title);

    const brand = document.createElement('p');
    brand.classList.add('card-text');
    brand.textContent = `Brand: ${product.brand}`;
    cardBody.appendChild(brand);

    const price = document.createElement('p');
    price.classList.add('card-text');
    price.textContent = `Price: $${product.price}`;
    cardBody.appendChild(price);

    const description = document.createElement('p');
    description.classList.add('card-text');
    description.textContent = product.description;
    cardBody.appendChild(description);

    const editButton = document.createElement('button');
    editButton.textContent = 'Modifica';
    editButton.classList.add('btn', 'btn-success', 'me-2');
    editButton.addEventListener('click', () => {
        window.location.href = `edit.html?id=${product._id}`;
    });
    cardBody.appendChild(editButton);

    const detailsButton = document.createElement('button');
    detailsButton.textContent = 'Dettagli';
    detailsButton.classList.add('btn', 'btn-primary', 'me-2');
    detailsButton.addEventListener('click', () => {
        showProductDetails(product._id);
    });
    cardBody.appendChild(detailsButton);

    card.appendChild(cardBody);

    return card;
};

const showProducts = async () => {
    try {
        const products = await fetchProducts();
        const cardsContainer = document.getElementById('cards-container');

        products.forEach((product) => {
            const card = createProductCard(product);
            cardsContainer.appendChild(card);
        });
    } catch (error) {
        console.error('Error showing products:', error);
    }
};
showProducts()


const showProductDetails = async (productId) => {
    try {
        const response = await fetch(`${baseUrl}/${productId}`, {
            headers: {
                Authorization: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZDYzZTJkN2IxMTAwMTkwZTZkY2UiLCJpYXQiOjE3MDk4ODkwODYsImV4cCI6MTcxMTA5ODY4Nn0.MNJxbluVwM9PHNe7Gp5FUZM3t97mK63sAS_7XovewMM"
            },
        });

        if (!response.ok) {
            throw new Error("Network response was not ok");
        }

        const product = await response.json();


        document.querySelector('main').innerHTML = '';
    
        const productDetails = document.createElement('div');
        productDetails.classList.add('product-details');

        const image = document.createElement('img');
        image.src = product.imageUrl;
        image.alt = product.name;
        image.classList.add('product-image'); 
        productDetails.appendChild(image);

        const productName = document.createElement('h2');
        productName.textContent = product.name;
        productName.classList.add('product-name');
        productDetails.appendChild(productName);

        const productBrand = document.createElement('p');
        productBrand.textContent = `Brand: ${product.brand}`;
        productBrand.classList.add('product-brand'); 
        productDetails.appendChild(productBrand);

        const productPrice = document.createElement('p');
        productPrice.textContent = `Price: $${product.price}`;
        productPrice.classList.add('product-price'); 
        productDetails.appendChild(productPrice);

        const productDescription = document.createElement('p');
        productDescription.textContent = product.description;
        productDescription.classList.add('product-description'); 
        productDetails.appendChild(productDescription);

        document.querySelector('main').appendChild(productDetails);
    } catch (error) {
        console.error('Error fetching product details:', error);
    }
};