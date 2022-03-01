import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { PasswordService } from '../../services/password.service';
import { catchError, of } from 'rxjs';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss']
})
export class ForgotPasswordComponent implements OnInit {
  forgotPasswordForm = this.formBuilder.group({
    email: ['', [Validators.required]],
  });
  globalSuccess = false;

  constructor(private formBuilder: FormBuilder, private passwordService: PasswordService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.passwordService.postForgotPassword(this.forgotPasswordForm.value)
      .pipe(
        catchError(() => of(null)),
      )
      .subscribe((value) => this.globalSuccess = true);
  }
}
