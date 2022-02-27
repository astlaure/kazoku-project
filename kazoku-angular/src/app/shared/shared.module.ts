import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { CardComponent } from './components/card/card.component';



@NgModule({
  declarations: [
    CardComponent
  ],
  exports: [
    CardComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class SharedModule { }
