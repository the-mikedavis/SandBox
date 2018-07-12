defmodule Override.Overrider do
  @behaviour Override.Behaviour

  @impl true
  def parse(number) when number in 1..2, do: true

  def parse(arg), do: Overide.Behaviour.parse(arg)
end
