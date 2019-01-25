import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { NursRoomComponent } from './nursroom/nursroom.component';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCheckboxModule} from '@angular/material';
import {MatButtonModule} from '@angular/material';
import {MatInputModule} from '@angular/material/input';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatDatepickerModule , MatNativeDateModule} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatSliderModule} from '@angular/material/slider';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatMenuModule} from '@angular/material/menu';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatStepperModule} from '@angular/material/stepper';
import {MatTabsModule} from '@angular/material/tabs';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import {MatPaginatorModule} from '@angular/material/paginator';
import { HomeComponent } from './home/home.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeService } from './service/home.service';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { GradeComponent } from './grade/grade.component';
import { MainhomeComponent } from './mainhome/mainhome.component';
import { PersonnalComponent } from './personnal/personnal.component';
import { StudentComponent } from './student/student.component';
const appRoutes: Routes = [
{ path: 'login', component: LoginComponent},
{ path: 'home', component: HomeComponent, children: [
{ path: 'mainhome', component: MainhomeComponent },
{ path: 'grade', component: GradeComponent },
{ path: 'nursroom', component: NursRoomComponent },
{ path: 'personnal', component: PersonnalComponent },
{ path: 'student', component: StudentComponent }
]
},
{ path: '**',   redirectTo: '/login'},

{ path: '',   redirectTo: '/login',pathMatch: 'full'
}

];

@NgModule({
  declarations: [
    AppComponent,
    NursRoomComponent,
    HomeComponent,
    GradeComponent,
    LoginComponent,
    MainhomeComponent,
    PersonnalComponent,
    StudentComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatCheckboxModule,
    MatButtonModule,
    MatInputModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatStepperModule,
    MatTabsModule,
    MatExpansionModule,
    MatButtonToggleModule,
    MatChipsModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatDialogModule,
    MatTooltipModule,
    MatSnackBarModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    RouterModule.forRoot(appRoutes),
    HttpModule,
    FormsModule,
    HttpClientModule,
MatNativeDateModule
  ],
  providers: [AppComponent,HomeService],
  bootstrap: [AppComponent]
})
export class AppModule { }

