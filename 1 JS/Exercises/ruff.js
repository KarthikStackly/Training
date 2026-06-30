const mobileNumber = Number(prompt("Enter your Mobile Number"));
if (mobileNumber.length === 10) {
  if (
    mobileNumber.at(0) === 6 ||
    mobileNumber.at(0) === 7 ||
    mobileNumber.at(0) === 8 ||
    mobileNumber.at(0) === 9
  ) {
    console.log("Valid Mobile Number");
  } else {
    console.log("Invalid Mobile Number");
  }
} else {
  console.log("Invalid Mobile Number");
}
