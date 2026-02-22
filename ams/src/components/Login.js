import { useState } from "react";
import { useNavigate } from "react-router-dom";
import API from "../services/api";

function Login({ setUser }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("STUDENT");

  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const url =
        role === "ADMIN" ? "/admin/login" : "/students/login";

      const response = await API.post(url, { email, password });

      setUser({ ...response.data, role });

      navigate(role === "ADMIN" ? "/admin" : "/student");
    } catch (error) {
      console.error("Login error:", error);
      alert("Login Failed");
    }
  };

  return (
    <div>
      <h2>Login</h2>

      <select onChange={(e) => setRole(e.target.value)}>
        <option value="STUDENT">Student</option>
        <option value="ADMIN">Admin</option>
      </select>

      <input
        placeholder="Email"
        onChange={(e) => setEmail(e.target.value)}
      />

      <input
        type="password"
        placeholder="Password"
        onChange={(e) => setPassword(e.target.value)}
      />

      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default Login;