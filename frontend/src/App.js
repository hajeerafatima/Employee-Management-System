import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route, BrowserRouter, useNavigate } from 'react-router-dom';
import { Login } from './components/Signup-Login/Login'
import Signup from './components/Signup-Login/Signup';
import  ResetPassword  from './components/Signup-Login/ResetPassword'
import EmployeeDashboard from './components/Dashboard/EmployeeDashboard';
import Home from './components/Dashboard/Home';
import Employee from './components/Dashboard/Employee';
import Skills from './components/Dashboard/Skills';
import AddSkills from './components/Dashboard/AddSkills';
import AddEmployee from './components/Dashboard/AddEmployee';
import EditEmployee from './components/Dashboard/EditEmployee';
import PrivateRoute from './components/Dashboard/PrivateRoute';
import ForgotPassword from './components/Signup-Login/ForgotPassword';

function App() {

   return (
    <div>
     <Router>
     <Routes>  
       <Route path='/signup' element={<Signup />} />
       <Route path='/' element={<Login />} />
       <Route path='/forgotpassword' element={<ForgotPassword />} />
       <Route path='/resetpassword'element={<ResetPassword/>} /> 
       <Route path='/dashboard' element={
       <PrivateRoute>
         <EmployeeDashboard/>
       </PrivateRoute>
       }>
         <Route path="" element={<Home />}></Route>
        
         <Route path='/dashboard/manageemployees' element={<Employee />}></Route>
         <Route path='/dashboard/skills' element={<Skills />}></Route>
         <Route path='/dashboard/add_skills' element={<AddSkills />}></Route>
         <Route path='/dashboard/add_employee' element={<AddEmployee />}></Route>
         <Route path='/dashboard/edit_employee/:id' element={<EditEmployee />}></Route>
         
        </Route> 
       {/* Other routes */}
     </Routes>
   </Router>
  </div>
   );
}

export default App;
