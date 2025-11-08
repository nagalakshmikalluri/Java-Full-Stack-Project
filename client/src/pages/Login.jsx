import React, { useState } from "react";
import api from "../services/api";

export default function Login() {
  const [form, setForm] = useState({ email: "", password: "" });

  const handleChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await api.post("/auth/login", form);
      const token = res.data.token;
      localStorage.setItem("token", token);
      alert("Logged in");
      window.location.href = "/";
    } catch (err) {
      alert(err.response?.data || err.message);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Login</h2>
      <input name="email" placeholder="Email" onChange={handleChange} required />
      <br />
      <input name="password" type="password" placeholder="Password" onChange={handleChange} required />
      <br />
      <button type="submit">Login</button>
    </form>
  );
}
