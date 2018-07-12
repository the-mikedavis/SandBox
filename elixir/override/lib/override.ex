defmodule Override do
  #@behaviour Override.Behaviour

  def parse(number) when number in 1..4, do: false
  def parse(5), do: true
  def parse(6), do: true
  def parse(7), do: true
end
