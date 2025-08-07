defmodule Messenger.Chat do
  @moduledoc false

  @spec handle_in(String.t(), map(), term()) :: {:reply, {:ok, map()}, term()} | {:noreply, term()}
  def handle_in("message:new", %{"cipher" => _cipher} = _payload, socket) do
    {:reply, {:ok, %{"status" => "queued"}}, socket}
  end

  def handle_in(_event, _payload, socket) do
    {:noreply, socket}
  end
end