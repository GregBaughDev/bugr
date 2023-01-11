<script lang='ts'>
  // Search for users by location
  // be able to click on a user page and display their user page show dates and reviews
  let state: string;

  const handleSearch = (): void => {
    console.log('search clicked. State: ' + state)
  }
</script>

<div class="w-10/12 p-4">
  <h2>Search</h2>
  <h3>Find users by state</h3>
  <div class="mt-2 flex justify-center flex-col">
    <div>
      <select name="location" id="location-search" class="border-2  border-[#240465] p-3 w-full" bind:value={state}>
        <option value="">Please select a state from the dropdown:</option>
        <option value="VIC">Victoria</option>
        <option value="NSW">New South Wales</option>
        <option value="SA">South Australia</option>
        <option value="QLD">Queensland</option>
        <option value="WA">Western Australia</option>
        <option value="TAS">Tasmania</option>
        <option value="ACT">ACT</option>
        <option value="NT">Northern Territory</option>
      </select>
    </div>
    <button type="submit" class="border-2 p-3 border-[#240465] mt-3" on:click={handleSearch} disabled={!state}>Search</button>
  </div>
  <h2>SORT OUT THE USERS TABLE TO SET ISCONFIRMED TO FALSE</h2> 
</div>