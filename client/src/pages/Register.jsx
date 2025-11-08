import React, { useState } from "react";
import api from "../services/api";

export default function Register() {
  const [form, setForm] = useState({ name: "", email: "", password: "", role: "SEEKER" });

  const handleChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await api.post("/auth/register", form);
      alert(res.data);
    } catch (err) {
      alert(err.response?.data || err.message);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Register</h2>
      <input name="name" placeholder="Name" onChange={handleChange} required />
      <br />
      <input name="email" placeholder="Email" onChange={handleChange} required />
      <br />
      <input name="password" type="password" placeholder="Password" onChange={handleChange} required />
      <br />
      <select name="role" onChange={handleChange} value={form.role}>
        <option value="SEEKER">Seeker</option>
        <option value="EMPLOYER">Employer</option>
      </select>
      <br />
      <button type="submit">Register</button>
    </form>
  );
}
