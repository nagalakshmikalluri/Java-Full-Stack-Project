import React, { useEffect, useState } from "react";
import api from "../services/api";

export default function Jobs() {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    api.get("/jobs").then((r) => setJobs(r.data)).catch(console.error);
  }, []);

  const apply = async (id) => {
    try {
      await api.post(`/jobs/${id}/apply`);
      alert("Applied");
    } catch (err) {
      alert(err.response?.data || err.message);
    }
  };

  return (
    <div>
      <h2>Jobs</h2>
      {jobs.length === 0 ? (
        <p>No jobs yet</p>
      ) : (
        jobs.map((j) => (
          <div key={j.jobId} style={{ border: "1px solid #ddd", padding: 12, marginBottom: 8 }}>
            <strong>{j.title}</strong> — {j.company}
            <div>{j.location} • {j.packageInfo}</div>
            <div>Skills: {j.skills}</div>
            <button onClick={() => apply(j.jobId)} style={{ marginTop: 8 }}>Apply</button>
          </div>
        ))
      )}
    </div>
  );
}
