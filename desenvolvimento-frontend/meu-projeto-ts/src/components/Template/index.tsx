import { Outlet } from 'react-router-dom';

export default function Template() {
  return (
    <div className="container bg-primary">
      <Outlet />
    </div>
  )
}