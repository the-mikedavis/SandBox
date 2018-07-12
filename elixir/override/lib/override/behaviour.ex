defmodule Override.Behaviour do
  @callback parse(integer()) :: boolean()

  def parse(number) when number in 1..7, do: false

  defoverridable parse: 1
end
