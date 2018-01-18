defmodule Chop do

  def guess(actual, a..b) do
    guess actual, a..b, div(a + b, 2)
  end

  def guess(actual, a..b, avg) when avg === actual do
    IO.puts avg
  end

  def guess(actual, a..b, avg) when avg > actual do
    ask avg
    guess actual, a..avg
  end

  def guess(actual, a..b, avg) when avg < actual do
    ask avg
    guess actual, avg..b
  end


  defp ask(n), do: IO.puts "Is it #{n}?"

end
