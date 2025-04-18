import { restPasswordForm, dashBoard,  forgotPasswordForm,signinForm, signupForm } from './register-url'


export const signUP = (user) => {
  return signupForm.post("/api/v1/signup/register", user)
    .then((response) => response.data); 
};

export const signIn = (user) => {
  return signinForm.post("/api/v1/signup/login", user)
  .then((response) => response.data);
}

export const forgotPassword = (user) => {
  return forgotPasswordForm.post("/api/v1/signup/forgotpassword", user)
  .then((response) => response.data);
}

export const resetPassword = (user, token) => {
  return restPasswordForm.post(`/api/v1/signup/resetpassword?token=${token}&password=${user}`)
    .then((response) => response.data);
};

export const dashboardSkills = (user) => {
  return dashBoard.post("/dashboard/add_skills", user)
  .then((response) => response.data);
}




