import { useState, useEffect } from "react";
import API from "../services/api";

function StudentDashboard() {
  const [batches, setBatches] = useState([]);

  useEffect(() => {
    const loadBatches = async () => {
      try {
        const response = await API.get("/batches");
        setBatches(response.data);
      } catch (error) {
        console.error("Error fetching batches:", error);
      }
    };

    loadBatches();
  }, []);

  return (
    <div>
      <h2>Student Dashboard</h2>

      <ul>
        {batches.map((batch) => (
          <li key={batch.id}>{batch.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default StudentDashboard;