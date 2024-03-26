import { Directive,ElementRef,Renderer2 } from '@angular/core';

@Directive({
  selector: '[appBgrandomColor]'
})
export class BgrandomColorDirective {
    colors: string [] = ['yellow','brown','red','blue','purple']
  constructor(private target: ElementRef,private render : Renderer2) {
      const randomIndex = Math.floor(Math.random() * this.colors.length);
      const randomColor= this.colors[randomIndex]
    this.render.setStyle(this.target.nativeElement,'backgroundColor',`${randomColor}`)
   }

}
