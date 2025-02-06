export const sendSortingRequest = async (array, algorithm) => {
    try {
      const response = await fetch("http://localhost:8080/api/sortSteps", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ array, algorithm }),
      });
      return await response.json();
    } catch (error) {
      console.error("Error fetching sorting steps:", error);
      return [];
    }
  };
  