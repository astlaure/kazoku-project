import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { CardComponent } from './components/card/card.component';
import { MessageComponent } from './components/message/message.component';



@NgModule({
  declarations: [
    CardComponent,
    MessageComponent
  ],
    exports: [
        CardComponent,
        MessageComponent
    ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class SharedModule { }
