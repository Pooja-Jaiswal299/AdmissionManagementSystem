import { Link, useNavigate } from "react-router-dom";

function Navbar({ user, setUser }) {
  const navigate = useNavigate();

  const logout = () => {
    setUser(null);
    navigate("/");
  };

  return (
    <div>
      <Link to="/">Login</Link> |{" "}
      <Link to="/register">Register</Link>

      {user && (
        <>
          {" | "}
          <button onClick={logout}>Logout</button>
        </>
      )}
    </div>
  );
}

export default Navbar;