Feature: Test SVTPlay

  Scenario: SVTPlay should show correct title
    Given SVTPlay is available
    When  User visits SVTPlay
    Then  Title should be "SVT Play"



Scenario: SVTPlay logo should visible
  Given SVTPlay is available
  When User visits SVTPlay
  Then logo should visible
  And Text should be "SVT Play logotyp"

Scenario: Main many's links should be Start, Program, Kanaler
  Given SVTPlay is available
  When   User visits SVTPlay
  And User Navigate to Links
  Then Main many should be "Start", "Program", "Kanaler"

Scenario: Availability within SVTPlay is visible and correct link text shows
  Given SVTPlay is available
  When  User visits SVTPlay
  Then Availability is visible with right text "Tillgänglighet i SVT Play"

  Scenario: Correct contents should shows by following Availability
    Given SVTPlay is available
    When  User visits SVTPlay
    And User Navigate to Availability
    Then Right contents heading should be "Så arbetar SVT med tillgänglighet"

Scenario: Program categories should find out under Program
  Given SVTPlay is available
  When  User visits SVTPlay
  And User navigate to Program
  Then It should count amount of categories  17

 Scenario: Program categories should shows by list
    Given SVTPlay is available
   When  User visits SVTPlay
  And User navigate to Program

   Then It should shows categories "Serier","Nyheter_test", "Dokumentär","Sport", "Barn", "Filmer", "Underhållning", "Livsstil & reality", "Fakta", "Humor", "Drama","Kultur", "Musik", "Samhälle", "Djur & natur", "Scen", "Öppet arkiv"
