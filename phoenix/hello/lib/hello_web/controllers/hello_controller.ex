defmodule HelloWeb.HelloController do
  use HelloWeb, :controller

  def index(conn, _params) do
    render conn, "index.html"
  end

  def show(conn, %{"messenger" => msgr}) do
    render conn, "show.html", messenger: msgr
  end
end
