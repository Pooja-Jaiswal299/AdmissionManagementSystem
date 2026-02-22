import { useState, useEffect } from "react";
import API from "../services/api";

function AdminDashboard() {
  const [batches, setBatches] = useState([]);
  const [batchName, setBatchName] = useState("");

  const loadBatches = async () => {
    try {
      const response = await API.get("/batches");
      setBatches(response.data);
    } catch (error) {
      console.error("Error loading batches:", error);
    }
  };

  useEffect(() => {
    loadBatches();
  }, []);

  const createBatch = async () => {
    try {
      await API.post("/batches", { name: batchName });
      setBatchName("");
      loadBatches();
    } catch (error) {
      console.error("Create batch error:", error);
    }
  };

  return (
    <div>
      <h2>Admin Dashboard</h2>

      <input
        value={batchName}
        placeholder="Batch Name"
        onChange={(e) => setBatchName(e.target.value)}
      />

      <button onClick={createBatch}>Create Batch</button>

      <ul>
        {batches.map((batch) => (
          <li key={batch.id}>{batch.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default AdminDashboard;