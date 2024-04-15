import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/service/products.service';
import { Products } from 'src/app/models/products.interface';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.scss'],
})
export class FavoritesComponent implements OnInit {
  favoriteProducts: Products[] = [];

  constructor(private productsSrv: ProductsService) {}

  ngOnInit(): void {
    this.productsSrv.favoriteSub.subscribe((products) => {
      this.favoriteProducts = products;
      console.log(this.favoriteProducts)
    });
  }
}
