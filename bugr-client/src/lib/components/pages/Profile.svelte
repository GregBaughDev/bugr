<script lang="ts">
  import { userDetails } from '../../state/userStore'
</script>

<h2>Profile</h2>
<h3>Username: {$userDetails.username}</h3>
<h3>Email: {$userDetails.email}</h3>
<h3>Location: {$userDetails.location}</h3>
<h3>State: {$userDetails.state}</h3>
<h3>User type: {$userDetails.userType}</h3>
<h3>About: {$userDetails.aboutBug}</h3>