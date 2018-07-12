defmodule OverrideTest do
  use ExUnit.Case
  doctest Override

  test "greets the world" do
    assert Override.hello() == :world
  end
end
