defmodule Realtime.MixProject do
  use Mix.Project

  def project do
    [app: :realtime, version: "0.1.0", elixir: "~> 1.17", start_permanent: Mix.env() == :prod, deps: deps()]
  end

  def application do
    [extra_applications: [:logger], mod: {Realtime.Application, []}]
  end

  defp deps do
    [{:phoenix, "~> 1.7"}, {:vernemq_dev, "~> 1.12"},
     {:scylla, "~> 0.10"}, {:jason, "~> 1.4"}]
  end
end