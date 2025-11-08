import React, { useState } from "react";
import api from "../services/api";

export default function CreateJob() {
  const [form, setForm] = useState({ title: "", company: "", location: "", packageInfo: "", skills: "" });

  const handleChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.post("/jobs", form);
      alert("Job created");
      window.location.href = "/";
    } catch (err) {
      alert(err.response?.data || err.message);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Create Job</h2>
      <input name="title" placeholder="Title" onChange={handleChange} required />
      <br />
      <input name="company" placeholder="Company" onChange={handleChange} required />
      <br />
      <input name="location" placeholder="Location" onChange={handleChange} />
      <br />
      <input name="packageInfo" placeholder="Package" onChange={handleChange} />
      <br />
      <input name="skills" placeholder="Skills" onChange={handleChange} />
      <br />
      <button type="submit">Create</button>
    </form>
  );
}
