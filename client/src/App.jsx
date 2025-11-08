import React from "react";
import { Routes, Route, Link } from "react-router-dom";
import Register from "./pages/Register";
import Login from "./pages/Login";
import Jobs from "./pages/Jobs";
import CreateJob from "./pages/CreateJob";

export default function App() {
  const handleLogout = () => {
    localStorage.removeItem("token");
    window.location.href = "/";
  };

  return (
    <div style={{ maxWidth: 900, margin: "20px auto", fontFamily: "Arial, sans-serif" }}>
      <header style={{ display: "flex", gap: 12, marginBottom: 20 }}>
        <Link to="/">Jobs</Link>
        <Link to="/create">Create Job</Link>
        <Link to="/register">Register</Link>
        <Link to="/login">Login</Link>
        <button onClick={handleLogout} style={{ marginLeft: "auto" }}>Logout</button>
      </header>

      <Routes>
        <Route path="/" element={<Jobs />} />
        <Route path="/create" element={<CreateJob />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </div>
  );
}
